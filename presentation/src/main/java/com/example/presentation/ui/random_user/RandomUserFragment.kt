package com.example.presentation.ui.random_user

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentRandomUserBinding
import com.example.presentation.extensions.loadImage
import com.example.presentation.extensions.observeApiResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RandomUserFragment : BaseFragment<FragmentRandomUserBinding>(R.layout.fragment_random_user) {


    private val viewModel: RandomUserViewModel by viewModels()
    override fun setUpUi() {
        viewModel.getUsers()
    }

    @SuppressLint("SetTextI18n")
    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.userResponse) { response ->
            response.results[0].let { user ->
                with(binding) {
                    imageUser.loadImage(user.picture.large)
                    tvValueName.text = "${user.name.first} ${user.name.last}"
                    tvValueEmail.text = user.email
                    tvValueBirthday.text = user.dob.date
                    tvValueAddress.text = user.location.street.getStreet()
                    tvValuePhone.text = user.phone
                    tvValuePassword.text = user.login.password
                }
            }
        }
    }


}