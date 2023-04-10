package com.example.coding_study

import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coding_study.databinding.StudyUploadLayoutBinding
import com.example.coding_study.databinding.WriteStudyBinding
import kotlinx.coroutines.NonDisposableHandle.parent

// 게시글의 정보를 담는 데이터 클래스 Post
data class Post(
    var nickname: String,
    var title: String,
    var content: String,
    var num: Long,
    var field: String,
    var currentTime: String
)

class StudyViewModel : ViewModel() {
    private val _postList = MutableLiveData<List<Post>>() // 내부에서만 업데이트 가능, 외부에서는 읽기 전용
    val postList: LiveData<List<Post>> = _postList // _postList를 postList라는 LiveData 변수로 노출

    fun addPost(post: Post) {
        val currentList = _postList.value.orEmpty().toMutableList()
        currentList.add(post)
        _postList.value = currentList // 게시글을 추가할 때마다 _postList 변수 업데이트
    }
}
