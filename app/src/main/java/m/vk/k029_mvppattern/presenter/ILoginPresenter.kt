package m.vk.k029_mvppattern.presenter

interface ILoginPresenter {
    fun doLogin(username: String,password: String)
    fun setProgressBarVisibility(visibility: Int)
}