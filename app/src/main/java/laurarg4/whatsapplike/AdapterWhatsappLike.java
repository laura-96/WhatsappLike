package laurarg4.whatsapplike;

import java.util.ArrayList;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Message;

import laurarg4.whatsapplike.R;
import java.util.Date;

public class AdapterWhatsappLike extends ArrayAdapter<Message> {

    private Context cont;

    private ArrayList<Message> messages;

    public AdapterWhatsappLike(Context context, int resource_id, ArrayList<Message> message) {

        super(context, resource_id);
        this.messages = message;
        this.cont = context;
    }

    @Override
    public View getView(int position, View conv_view, ViewGroup parent)
    {
        ViewHolder view_holder = null;
        LinearLayout layout;

        if(conv_view == null)
        {
            layout = (LinearLayout) View.inflate(cont, R.layout.activity_chat, null);
            view_holder = new ViewHolder();

        }
        else
        {
            layout = (LinearLayout) conv_view;
        }

        Message mess = getItem(position);
        view_holder.mess.setText(mess.toString());

        return layout;
    }


    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    public void setArrayList(ArrayList<Message> message_list) {
        this.messages.addAll(message_list);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public TextView mess;
    }
}
