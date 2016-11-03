package laurarg4.whatsapplike;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Message;
import android.view.View;

import java.util.ArrayList;


public class ActivityChat extends Activity{

    private ArrayList<Message> dialogue;
    private ListView conversation;
    private AdapterWhatsappLike adapter_wl;

    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_chat);

        String[] string_array = readArgs();

        TextView nick = (TextView) findViewById(R.id.text_nick);
        nick.setText(string_array[0] + "@" + string_array[1] + ":" + string_array[2]);

        dialogue = new ArrayList<Message>();
        conversation = (ListView) findViewById(R.id.conversation);
        adapter_wl = new AdapterWhatsappLike(this, R.id.conversation, dialogue);

        //Message message_content = new Message();
        //Bundle msg = new Bundle();
        //msg.putString("","Hola");
        //message_content.setData(msg);
        //dialogue.add(message_content);

        conversation.setAdapter(adapter_wl);

    }

    String[] readArgs()
    {

        Bundle extra_bundle = getIntent().getExtras();
        String[] ret = extra_bundle.getStringArray("Arguments");

        return ret;
    }

    public void addText(final View view) {

        EditText input_text = (EditText) findViewById(R.id.input);
        if(input_text.getEditableText().toString().equals("")) return;

        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });
    }
}
