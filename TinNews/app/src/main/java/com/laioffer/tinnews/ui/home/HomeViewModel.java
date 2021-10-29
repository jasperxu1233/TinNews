package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

public class HomeViewModel extends ViewModel {  //view model层，监听用户的输入数据
    private final NewsRepository newsRepository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();

    public HomeViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void setCountryInput(String country) {
        countryInput.setValue(country);
    }

    public LiveData<NewsResponse> getTopHeadlines() {  //传入用户输入的数据和getTopHeadlines这个函数-->repo的get时的参数定义等。
        return Transformations.switchMap(countryInput, newsRepository::getTopHeadlines);
    }

    public void setFavoriteArticleInput(Article article) {
        newsRepository.favoriteArticle(article);
    }

}