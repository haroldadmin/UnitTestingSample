package com.kshitijchauhan.haroldadmin.unittests.comments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshitijchauhan.haroldadmin.unittests.comments.databinding.FragmentsCommentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CommentsFragment : Fragment() {

    private val commentsViewModel by viewModel<CommentsViewModel>()
    private val args by navArgs<CommentsFragmentArgs>()
    private val commentsAdapter by inject<CommentsAdapter> { parametersOf(args.postId) }

    private lateinit var binding: FragmentsCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Comments.init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentsCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.commentsRv.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            val divider = DividerItemDecoration(requireContext(), linearLayoutManager.orientation)

            adapter = commentsAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        commentsViewModel.comments.observe(viewLifecycleOwner, Observer {
            commentsAdapter.submitList(it)
        })
    }

}
