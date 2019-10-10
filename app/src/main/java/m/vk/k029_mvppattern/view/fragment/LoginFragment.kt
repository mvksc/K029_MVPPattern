package m.vk.k029_mvppattern.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import m.vk.k029_mvppattern.R
import m.vk.k029_mvppattern.presenter.ILoginPresenter
import m.vk.k029_mvppattern.presenter.LoginPresenterCompI


class LoginFragment : Fragment(),ILoginFragment{

    companion object {
        lateinit var iLoginPresenter: ILoginPresenter
        @JvmStatic
        fun newInstance() = LoginFragment().apply {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iLoginPresenter = LoginPresenterCompI(this)

        tvLogin.setOnClickListener{
            onLogin()
        }
    }
    private fun onLogin(){
        iLoginPresenter.setProgressBarVisibility(View.VISIBLE)
        var username = edUsername.text.toString()
        var password = edPassword.text.toString()
        iLoginPresenter.doLogin(username,password)
    }

    override fun onLoginResult(result: String) {
        iLoginPresenter.setProgressBarVisibility(View.GONE)
        Toast.makeText(activity,result, Toast.LENGTH_SHORT).show()
    }
    override fun onProgressBarVisibility(visibility: Int) {
        pbLogin.visibility = visibility
    }
}
