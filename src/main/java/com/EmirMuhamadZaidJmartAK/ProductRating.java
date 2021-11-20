package com.EmirMuhamadZaidJmartAK;

// + = public
// - = private
// _ = static

public class ProductRating{
    private long total;
    private long count;
    
    public ProductRating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating){
            this.total = this.total + rating;
            this.count++;
    }
    
    public double getAverage(){
        double getAverageValue;
        if (this.total == 0 || this.count == 0){
            getAverageValue = 0;
        }else{
            getAverageValue = this.total / this.count;
        }
        return getAverageValue;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
    
}