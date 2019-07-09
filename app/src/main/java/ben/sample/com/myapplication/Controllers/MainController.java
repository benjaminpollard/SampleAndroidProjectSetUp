package ben.sample.com.myapplication.Controllers;
import android.app.Activity;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainController extends BaseController {

    private MutableLiveData<String> liveDataA = new MutableLiveData<>();



    public void SetLiseners(LifecycleOwner owner, Observer<String> observer)
    {
        liveDataA.observe(owner, observer);
    }
    public void buttonClicked()
    {
        liveDataA.postValue("ben");
    }
}
