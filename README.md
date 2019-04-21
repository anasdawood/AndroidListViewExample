# AndroidListViewExample
This code has all the files required to implement a simple ListView  in android

You will need :

1- A layout file for your ListView (messages_list.xml)
2- A layout file for a single entry in your listview (message_list_item.xml)
3- A POJO class to represent your single entry layout (MessageEntry)
4- An Adapter where you override "getView" to map your single entry class (MessageEntry) with your single entry view(message_list_item).

Finally, in your main activity, create a list of your single entry class and fill it with the required data nad then pass it to your adapter.
