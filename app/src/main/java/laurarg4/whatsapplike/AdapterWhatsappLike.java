package laurarg4.whatsapplike;

import java.util.ArrayList;
import java.util.Random;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Message;

import laurarg4.whatsapplike.R;
import java.util.Date;

public class AdapterWhatsappLike extends BaseAdapter {

    private Context cont;
    private ArrayList<String> messages;

    public AdapterWhatsappLike(Context context, ArrayList<String> message) {

        this.messages = message;
        this.cont = context;
    }

    public View getView(int position, View conv_view, ViewGroup parent)
    {
        ViewHolder view_holder;

        if(conv_view==null){

            if(getItemViewType(position) == 0)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_local, parent, false);
            if(getItemViewType(position) == 1)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_remote, parent, false);
            if(getItemViewType(position) == 2)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_date, parent, false);

            view_holder = new ViewHolder();
            view_holder.mess  = (TextView)  conv_view.findViewById(R.id.text);
            conv_view.setTag(view_holder);
        }

        view_holder = (ViewHolder)conv_view.getTag();

        if(getItemViewType(position) == 0 || getItemViewType(position) == 1) {

            view_holder.mess.setText(messages.get(position));

        }


        if(getItemViewType(position) == 2)
        {

            Date date = new Date();
            view_holder.mess.setText(date.toLocaleString());

        }


        return conv_view;
    }


    public Object getItem(int arg0) {
        return messages.get(arg0);
    }

    public long getItemId(int arg0) {
        return arg0;
    }


    @Override
    public int getItemViewType(int position) {

        Random rnd = new Random();
        int ret = (int)(rnd.nextInt()*100+1);

        return ret % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return messages.size();
    }



    private class ViewHolder {
        public TextView mess;
    }
}
