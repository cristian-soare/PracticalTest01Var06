package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    private EditText addrEdit, passEdit;
    private Button okButton, cancelButton;

    private OkButtonListener okButtonListener = new OkButtonListener();
    private class OkButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }

    }

    private CancelButtonListener cancelButtonListener = new CancelButtonListener();
    private class CancelButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        addrEdit = (EditText)findViewById(R.id.secAddrEdit);
        passEdit = (EditText)findViewById(R.id.secPassEdit);

        okButton = (Button)findViewById(R.id.okButton);
        okButton.setOnClickListener(okButtonListener);

        cancelButton = (Button)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(cancelButtonListener);

        Intent intent = getIntent();
        if (intent != null) {
            addrEdit.setText(intent.getStringExtra("addr"));
            passEdit.setText(intent.getStringExtra("pass"));
        }
    }
}
