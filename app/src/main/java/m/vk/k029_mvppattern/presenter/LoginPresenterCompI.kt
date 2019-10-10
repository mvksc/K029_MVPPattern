package m.vk.k029_mvppattern.presenter

import android.os.Handler
import m.vk.k029_mvppattern.view.fragment.ILoginFragment

class LoginPresenterCompI: ILoginPresenter {
    private var iLoginFragment: ILoginFragment
    private var mHandler: Handler
    constructor(iLoginFragment: ILoginFragment){
        this.iLoginFragment = iLoginFragment
        this.mHandler = Handler()
    }

    override fun doLogin(username: String, password: String) {
        if (!(username.trim() == "" || password.trim() == "")){
            //check your server login
            mHandler.postDelayed({
                iLoginFragment.onLoginResult("Login successful.")
            },3000)
        }else{
            iLoginFragment.onLoginResult("Login fail check enter username and password.")
        }
    }

    override fun setProgressBarVisibility(visibility: Int) {
        iLoginFragment.onProgressBarVisibility(visibility)
    }
}