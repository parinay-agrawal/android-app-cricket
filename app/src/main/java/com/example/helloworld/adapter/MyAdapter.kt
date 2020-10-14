import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.data.Comment

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
class CommentsAdapter (private val mComments: List<Comment>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val name = itemView.findViewById<TextView>(R.id.name)
        val message = itemView.findViewById<TextView>(R.id.message)
        val votes = itemView.findViewById<TextView>(R.id.votes)
        val upvote = itemView.findViewById<Button>(R.id.upvote)
        val downvote = itemView.findViewById<Button>(R.id.downvote)
        val reply = itemView.findViewById<Button>(R.id.reply)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.linear_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: CommentsAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val comment: Comment = mComments.get(position)
        // Set item views based on your views and data model
        val name = viewHolder.name
        val message = viewHolder.message
        val votes = viewHolder.votes
        val upvote = viewHolder.upvote
        val downvote = viewHolder.downvote
        val reply = viewHolder.reply
        val level = comment.level

        name.setPadding(20*level + 5, 0, 0, 0)
        name.setText(comment.name)

        message.setPadding(20*level + 5, 0, 0, 0)
        message.setText(comment.message)

        votes.setText(comment.votes.toString())
        upvote.setText("+")
        downvote.setText("-")
        reply.setText("R")
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mComments.size
    }

}