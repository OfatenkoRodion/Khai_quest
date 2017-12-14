package RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import Entity.MyQrCode;
import ro.khai_quest.R;

public class QrCodeRecyclerAdapter extends RecyclerView.Adapter<QrCodeRecyclerViewHolder>
{

    private ArrayList<MyQrCode> myQrCodes = new ArrayList<>();
    private Context context;
    public void addAll(ArrayList<MyQrCode> newQrCodes, Context context)
    {
        this.context=context;
        myQrCodes.clear();
        int pos = getItemCount();
        this.myQrCodes.addAll(newQrCodes);
        notifyItemChanged(pos,this.myQrCodes.size());
    }

    @Override
    public QrCodeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qr_code_card_item,parent,false);
        return new QrCodeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QrCodeRecyclerViewHolder holder, int position)
    {
        holder.bind(myQrCodes.get(position));
    }

    @Override
    public int getItemCount()
    {
        return myQrCodes.size();
    }
}
