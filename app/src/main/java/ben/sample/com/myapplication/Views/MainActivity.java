package ben.sample.com.myapplication.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ben.sample.com.myapplication.Controllers.MainController;
import ben.sample.com.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MainController mainController = new MainController();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProviders.of(this).get(MainController.class);

        textView = findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(this);

        mainController.SetLiseners(this, new Observer<String>() {
            @Override
            public void onChanged(String o) {
                textView.setText(textView.getText() + " " + o );
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
            mainController.buttonClicked();
                break;
        }
    }


}
