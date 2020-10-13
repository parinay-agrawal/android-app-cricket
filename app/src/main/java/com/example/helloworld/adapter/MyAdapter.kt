import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.data.Contact

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class ContactsAdapter (private val mContacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val comment = itemView.findViewById<TextView>(R.id.message)
        val votes = itemView.findViewById<TextView>(R.id.votes)
        val upvote = itemView.findViewById<Button>(R.id.upvote)
        val downvote = itemView.findViewById<Button>(R.id.downvote)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.linear_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ContactsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Contact = mContacts.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.comment
        textView.setPadding(20*position + 5, 0, 0, 0)
        textView.setText(contact.name)
        val votes = viewHolder.votes
        votes.setText("5")
        val button1 = viewHolder.upvote
        val button2 = viewHolder.downvote
        button1.text = "+"
        button2.text = "-"
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mContacts.size
    }

}