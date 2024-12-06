package com.shivansh.retrofitplayground.presentation.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivansh.retrofitplayground.R
import com.shivansh.retrofitplayground.databinding.ActivityMainBinding
import com.shivansh.retrofitplayground.presentation.adapter.PostsAdapter
import com.shivansh.retrofitplayground.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
//        PostsAdapter.con = this
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val postsAdapter = PostsAdapter()
        val postsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.postsList.apply {
            adapter = postsAdapter
            layoutManager = postsLayoutManager
        }


        lifecycleScope.launch {
            repeatOnLifecycle(state = Lifecycle.State.CREATED) {
                viewModel.posts.collect {
                    Log.d("Posts", it.toString())
                    postsAdapter.updateData(it)
                }
            }
        }

    }


}