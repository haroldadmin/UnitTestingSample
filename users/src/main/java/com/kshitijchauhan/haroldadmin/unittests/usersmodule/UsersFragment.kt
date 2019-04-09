package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.databinding.FragmentUsersBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class UsersFragment : Fragment() {

    private val viewModel by viewModel<UsersViewModel>()
    private val usersAdapter by inject<UsersAdapter>()

    private lateinit var binding: FragmentUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Users.init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUsersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.usersRv.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext())
            val divider = DividerItemDecoration(requireContext(), linearLayoutManager.orientation)
            layoutManager = linearLayoutManager
            adapter = usersAdapter
            addItemDecoration(divider)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.users.observe(viewLifecycleOwner, Observer {
            usersAdapter.submitList(it)
        })
    }
}
