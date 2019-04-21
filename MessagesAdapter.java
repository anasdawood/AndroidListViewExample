package com.attoon.functions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.attoon.R;


import java.util.ArrayList;

import java.util.List;


import entities.MessageEntry;


public class MessagesAdapter extends ArrayAdapter<MessageEntry> {

    private Context mContext;
    private List<MessageEntry> messagesList = new ArrayList<>();

    public MessagesAdapter(@NonNull Context context, ArrayList<MessageEntry> list) {
        super(context, 0, list);
        mContext = context;
        messagesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.message_list_item, parent, false);

        MessageEntry currentMessage = messagesList.get(position);

        final TextView name = listItem.findViewById(R.id.textView_sender_name);
        name.setText(currentMessage.getUserName());

        final TextView release = listItem.findViewById(R.id.textView_message);
        release.setText(currentMessage.getMessage());

        final TextView firebaseId = listItem.findViewById(R.id.textView_fire_base_id);
        firebaseId.setText(currentMessage.getFirbaseId());
        return listItem;
    }
}
