package com.EmirMuhamadZaidJmartAK;

// + = public
// - = private
// _ = static

/**
 * Product rating class
 */
public class ProductRating{
    private long total;
    private long count;

    /**
     * product rating constructor
     */
    public ProductRating(){
        this.total = 0;
        this.count = 0;
    }

    /**
     * put a rating
     * @param rating
     */
    public void insert(int rating){
            this.total = this.total + rating;
            this.count++;
    }

    /**
     * get average of all rating
     * @return
     */
    public double getAverage(){
        double getAverageValue;
        if (this.total == 0 || this.count == 0){
            getAverageValue = 0;
        }else{
            getAverageValue = this.total / this.count;
        }
        return getAverageValue;
    }

    /**
     * get count
     * @return
     */
    public long getCount(){
        return this.count;
    }

    /**
     * get total
     * @return
     */
    public long getTotal(){
        return this.total;
    }
    
}