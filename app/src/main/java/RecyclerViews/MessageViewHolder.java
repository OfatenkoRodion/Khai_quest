package RecyclerViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import Entity.MyQrCode;
import ro.khai_quest.R;

public class MessageViewHolder extends RecyclerView.ViewHolder
{
    private TextView textView;
    public MessageViewHolder(View itemView)
    {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.textViewMessage);
    }

    public void bind (MyQrCode myQrCode)
    {
        if (!myQrCode.isOpen())
        textView.setText(myQrCode.getMessage()+" Активно!");
        else textView.setText(myQrCode.getMessage()+" Выполнено.");
    }
}
