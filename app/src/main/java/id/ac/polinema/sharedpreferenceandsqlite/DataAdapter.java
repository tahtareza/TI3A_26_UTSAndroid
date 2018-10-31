package id.ac.polinema.sharedpreferenceandsqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    ArrayList<DataModel> dataset;

    public DataAdapter(ArrayList<DataModel> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        DataViewHolder viewHolder=new DataViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel item = dataset.get(position);
        holder.textItem.setText((item.getNama()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        TextView textItem;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            textItem=itemView.findViewById(R.id.txtItem);
        }
    }
}
