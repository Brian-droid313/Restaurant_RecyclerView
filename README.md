# Restaurant_RecyclerView
<p>This is an android app that I made to play around with RecyclerView.</p>

<p>What this app does does is it uses a list of restaurants and puts them in a RecylerView.
Each view holder can be clicked on to open another fragment to see information about a website.</p>

<p>Each fragment that opens up from each view holder will have a link to the restaurant's website by clicking on a button.</p>
<p>NOTE: The ratings for each restaurant is not my rating. They are random.</p>

## Observations
<p>If you may have noticed, my RestaurantData.java is kind of bad. This was just to inject data that my app can use. To make it more better, I made it into a singleton so that only a single object would exist whenever the app is ran, thus making it less prone to errors. Though there are probably work arounds to change the data mistakenly.</p>
