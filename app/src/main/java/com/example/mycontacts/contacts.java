package com.example.mycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class contacts extends RecyclerView.Adapter<contacts.ViewHolder> {
    public interface contactclicked{
        void oncontactclicked(int index);
    }
    private ArrayList<person> contactsno;
    contactclicked activity;
    private Context context;
    public contacts(Context context, ArrayList<person>list)
    {
        activity= (contacts.contactclicked) context;
        contactsno =list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnLongClickListener {
        ImageView impreference;
        TextView tvname,tvemail,tvadress,tvdateofbirth;
        EditText etno;
        ImageView imdelete,imcall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            impreference = itemView.findViewById(R.id.impreference);
            tvname = itemView.findViewById(R.id.tvname);
            imcall = itemView.findViewById(R.id.imcall);
            tvemail = itemView.findViewById(R.id.tvemail);
            etno = itemView.findViewById(R.id.etno);
            tvadress=itemView.findViewById(R.id.tvadress);
            tvdateofbirth=itemView.findViewById(R.id.tvdateofbirth);
            etno.setVisibility(View.INVISIBLE);
            tvdateofbirth.setVisibility(View.INVISIBLE);
            tvadress.setVisibility(View.INVISIBLE);
            itemView.setOnLongClickListener(this);

            imdelete = itemView.findViewById(R.id.imdelete);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.oncontactclicked(contactsno.indexOf((person) itemView.getTag()));
                }
            });

        }

        @Override
        public boolean onLongClick(View v) {
            imdelete.setVisibility(View.VISIBLE);
            imdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAbsoluteAdapterPosition();
                    contactsno.remove(position);
                    notifyItemRemoved(position);

                }
            });
            return true;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View w = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false);
        return new contacts.ViewHolder(w);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(contactsno.get(position));
        holder.tvname.setText(contactsno.get(position).getName());
        holder.tvemail.setText(contactsno.get(position).getEmail());
        holder.etno.setText(contactsno.get(position).getNo());
        holder.tvadress.setText(contactsno.get(position).getAdress());
        holder.tvdateofbirth.setText(contactsno.get(position).getDateofbirth());

        if (contactsno.get(position).getPreference().equals("maham")) {
            holder.impreference.setImageResource(R.drawable.maham);
        } else if (contactsno.get(position).getPreference().equals("tooba")) {
            holder.impreference.setImageResource(R.drawable.tooba);
        } else if (contactsno.get(position).getPreference().equals("bhai")) {
            holder.impreference.setImageResource(R.drawable.bhai);
        } else if (contactsno.get(position).getPreference().equals("aiza")) {
            holder.impreference.setImageResource(R.drawable.aiza);
        } else if (contactsno.get(position).getPreference().equals("hania")) {
            holder.impreference.setImageResource(R.drawable.hania);
        } else if (contactsno.get(position).getPreference().equals("ahad")) {
            holder.impreference.setImageResource(R.drawable.ahad);
        }
    }

    @Override
    public int getItemCount() {
        if(contactsno!=null){
            return contactsno.size();
        } else{
            return 0;
        }
        //return contactsno.size();
    }
}