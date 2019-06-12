package com.ruler.fighting.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ruler.fighting.R;
import com.ruler.fighting.bean.HomeBean;

import java.util.ArrayList;

import butterknife.OnClick;
import okhttp3.internal.ws.RealWebSocket;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 11:31
 * year:2019
 * project_name:fighting
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<HomeBean.ResultsBean> list;

    public HomeAdapter(Context context, ArrayList<HomeBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item1, null, false);
            return new ViewHolder1(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item2, null, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            int mposition = i;
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            Glide.with(context).load(list.get(mposition).getUrl()).into(viewHolder1.imageView);
            viewHolder1.textView.setText(list.get(mposition).getDesc());
        } else if (itemViewType == 2) {
            int mposition = i;
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            Glide.with(context).load(list.get(mposition).getUrl()).into(viewHolder2.imageView2);
            viewHolder2.textView2.setText(list.get(mposition).getDesc());
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recOnclick!=null){
                    recOnclick.OnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0) {
            return 1;
        } else {
            return 2;
        }

    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_item1);
            textView = itemView.findViewById(R.id.tv_item1);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView imageView2;
        private TextView textView2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.img_item2);
            textView2 = itemView.findViewById(R.id.tv_item2);
        }
    }
   public interface RecOnclick{
       void OnClick (int i);
   }
   public RecOnclick recOnclick;

    public void setRecOnclick(RecOnclick recOnclick) {
        this.recOnclick = recOnclick;
    }
}
