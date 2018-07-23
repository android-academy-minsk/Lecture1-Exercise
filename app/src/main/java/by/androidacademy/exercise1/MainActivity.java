package by.androidacademy.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_email).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_activity:
                SecondActivity.show(this, getMessage());
                break;

            case R.id.btn_email:
                sendEmail();
                break;
        }
    }

    private String getMessage() {
        final TextView messageTextView = findViewById(R.id.et_message);
        return messageTextView.getText().toString();
    }

    private void sendEmail() {
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email_to)});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        emailIntent.putExtra(Intent.EXTRA_TEXT, getMessage());
        emailIntent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.choose_email_client)));
        } catch (Exception e) {
            Log.e(TAG, getString(R.string.email_error), e);
        }
    }
}
