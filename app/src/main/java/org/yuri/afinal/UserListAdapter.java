package org.yuri.afinal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {


    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> noticeList) {
        this.context = context;
        this.userList = noticeList;
    }

    @Override
    public int getCount() {
        return userList.size();

    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.user, null);


        TextView userId = (TextView) v.findViewById(R.id.userId);
        TextView userName = (TextView) v.findViewById(R.id.userName);
        TextView userEmail = (TextView) v.findViewById(R.id.userEmail);
        TextView userGender = (TextView) v.findViewById(R.id.userGender);


        userId.setText(userList.get(i).getId());
        userName.setText(userList.get(i).getName());
        userEmail.setText(userList.get(i).getEmail());
        userGender.setText(userList.get(i).getGender());
        v.setTag(userList.get(i).getId());
        return v;
    }
}