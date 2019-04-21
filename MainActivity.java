private ListView messagesListView;
messagesListView = findViewById(R.id.messages_list);

ArrayList<MessageEntry> messages = new ArrayList<>();
    for (int i=0;i<5;i++) {
        messages.add(new MessageEntry(i.toString(),"Entry #" + i));
    }
MessagesAdapter arrayAdapter
        = new MessagesAdapter(getActivity(), messages);

messagesListView.setAdapter(arrayAdapter);
