package dev.chu.myapplication.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import dev.chu.myapplication.databinding.FragmentUserBinding
import dev.chu.myapplication.di.AppViewModelFactory
import java.lang.Exception
import javax.inject.Inject

class UserFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    lateinit var binding: FragmentUserBinding

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        if(savedInstanceState == null) {
            arguments?.let {
                val args = UserFragmentArgs.fromBundle(it)
                viewModel.loadUser(args.userId)
            } ?: run {
                throw Exception("argument is null")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}