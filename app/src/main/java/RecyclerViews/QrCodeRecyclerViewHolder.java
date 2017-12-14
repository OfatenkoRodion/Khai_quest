package RecyclerViews;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import Entity.MyQrCode;
import ro.khai_quest.R;

public class QrCodeRecyclerViewHolder extends RecyclerView.ViewHolder
{
    private TextView textView;
    public QrCodeRecyclerViewHolder(View itemView)
    {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.textViewQrCode);
    }

    public void bind (MyQrCode myQrCode)
    {
        textView.setText("id:"+myQrCode.getId());
    }
}
