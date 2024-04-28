**Q:** When overriding the equals() method of the Object class, you will have to cast the Object parameter obj to the type of Object that you are dealing with. For example, in the Media class, you must cast the Object obj to a Media, and then check the equality of the two objects’ attributes as the above requirements (i.e. title for Media; title and length for Track). If the passing object is not an instance of Media, what happens?

**A**: If attempting to cast an object to a class that it is not an instance of, or if the class it is cast to does not have the appropriate method, Java will throw a `ClassCastException` at runtime.

**Question**: Alternatively, to compare items in the cart, instead of using the Comparator class I have mentioned, you can use the Comparable interface and override the `compareTo()`method. You can refer to the Java docs to see the information of this interface.
Suppose we are taking this `Comparable` interface approach.

1. What class should implement the Comparable interface?
   - The `Media` class should implement the `Comparable` interface because `Media` objects need to be compared and ordered.
2. How should you implement the `compareTo()` method to reflect the ordering that we want?

   - I will implement like this in case of sorting by title_cost

   ```java
   public abstract class Media implements Comparable<Media>{
   	#Override
    public int compareTo(Media media) {
        int costComparison = Float.compare(this.cost, media.getCost());
        if (costComparison == 0) {
            return this.title.compareTo(media.getTitle());
        }
        return costComparison;
    }
   }
   ```

3. Can we have two ordering rules of the item (by title then cost and by cost then title) if we use this Comparable interface approach?
   - No, the `Comparable` interface allows defining only one natural ordering for objects. If we need multiple ordering rules, we should use a `Comparator` for each rule or define a single rule in the `compareTo()` method that encompasses all the desired ordering criteria.
4. Suppose the DVDs have a different ordering rule from the other media types, that is by title, then decreasing length, then cost. How would you modify your code to allow this?
   - Implement the `Comparable<DigitalVideoDisc>` method in the `DigitalVideoDisc` class.
   - Override the `compareTo()` method to define the specific ordering rule for DVDs.
