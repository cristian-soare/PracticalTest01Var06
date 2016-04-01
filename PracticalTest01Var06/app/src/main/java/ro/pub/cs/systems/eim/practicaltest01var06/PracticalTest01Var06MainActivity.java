package ro.pub.cs.systems.eim.practicaltest01var06;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private Button lessButton, passButton;
    private EditText firstEdit, addrEdit;
    private LinearLayout tohide;

    private LessButtonListener lessButtonListener = new LessButtonListener();
    private class LessButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (tohide.getVisibility() == LinearLayout.VISIBLE) {
                tohide.setVisibility(LinearLayout.GONE);
                lessButton.setText(getResources().getString(R.string.more_details));
            } else {
                tohide.setVisibility(LinearLayout.VISIBLE);
                lessButton.setText(getResources().getString(R.string.less_details));
            }
        }

    }

    private AddrTextChangedListener addrTextChanged = new AddrTextChangedListener();
    private class AddrTextChangedListener implements TextWatcher {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() >= 4 && s.subSequence(0, 4).toString().equals("http")) {
                passButton.setText(getResources().getString(R.string.pass_butt));
                passButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.colorPassValid));
            } else {
                passButton.setText(getResources().getString(R.string.fail_butt));
                passButton.setBackground(getApplicationContext().getResources().getDrawable(R.color.colorPassInvalid));
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        lessButton = (Button)findViewById(R.id.lessButton);
        lessButton.setOnClickListener(lessButtonListener);

        addrEdit = (EditText)findViewById(R.id.addr_edit);
        addrEdit.addTextChangedListener(addrTextChanged);

        firstEdit = (EditText)findViewById(R.id.firstEdit);
        tohide = (LinearLayout)findViewById(R.id.tohide);

        passButton = (Button)findViewById(R.id.passButton);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("firstEdit", firstEdit.getText().toString());
        bundle.putString("addrEdit", addrEdit.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        firstEdit.setText(bundle.getString("firstEdit", ""));
        addrEdit.setText(bundle.getString("addrEdit",  ""));
    }
}
