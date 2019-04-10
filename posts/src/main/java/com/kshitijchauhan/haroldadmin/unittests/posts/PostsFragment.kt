package com.kshitijchauhan.haroldadmin.unittests.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Post
import com.kshitijchauhan.haroldadmin.unittests.posts.databinding.FragmentPostsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostsFragment : Fragment() {

    private val args by navArgs<PostsFragmentArgs>()
    private val postsViewModel by viewModel<PostsViewModel> { parametersOf(args.userId) }
    private val callbacks by lazy {
        object : PostsViewHolder.Callbacks {
            override fun onPostClick(post: Post) {
                findNavController().navigate(PostsFragmentDirections.viewComments(post.id))
            }
        }
    }
    private val postsAdapter by inject<PostsAdapter> { parametersOf(callbacks) }

    private lateinit var binding: FragmentPostsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Posts.init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.postsRv.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            val divider = DividerItemDecoration(requireContext(), linearLayoutManager.orientation)
            adapter = postsAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        postsViewModel.posts.observe(viewLifecycleOwner, Observer {
            postsAdapter.submitList(it)
        })
    }
}
