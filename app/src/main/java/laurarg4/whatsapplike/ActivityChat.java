package laurarg4.whatsapplike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityChat extends Activity{
    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_chat);
    }

    String[] readArgs()
    {
        Intent act_intent = getIntent();

        String[] ret = act_intent.getExtras().getStringArray("Arguments");
        TextView t = (TextView)findViewById(R.id.nick);
        t.setText(ret[0]);

        return ret;
    }
}
