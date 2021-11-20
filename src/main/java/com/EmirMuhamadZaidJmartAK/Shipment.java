package com.EmirMuhamadZaidJmartAK;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Shipment implements FileParser
{
    public String address; 
    public String receipt;
    public Duration duration;
    public int shipmentCost;
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("'Date Format'E, MM/dd/yyyy");
    private byte bit;
    
    public static class Duration{
        
        
        public static final Duration INSTANT = new Duration ((byte)(1 << 0)); //0000 0001
        public static final Duration SAME_DAY = new Duration ((byte)(1 << 1)); //0000 0010
        public static final Duration NEXT_DAY = new Duration ((byte)(1 << 2)); //0000 0100
        public static final Duration REGULER = new Duration ((byte)(1 << 3)); //0000 1000
        public static final Duration KARGO = new Duration ((byte)(1 << 4)); //0001 0000
        
        private byte bit;
        private Duration(byte bit){
            this.bit = bit;
        }
    }
    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.shipmentCost = cost;
        this.bit = plan;
        this.receipt =receipt;

    }
    
    public class MultiDuration{
        public byte bit;
        public MultiDuration(byte ... args){
            for (byte i : args){
                this.bit = (byte)(this.bit | i);
            }
        }
        
        public boolean isDuration(Duration reference){
            if ((reference.bit&this.bit) != 0){
                return true;
            }else{
                return false;
            }
        }
    }
    public String getEstimatedArrival(Date reference){
            Calendar temp = Calendar.getInstance();
                if(this.bit == 1<<0|| this.bit == 1<<1){
                    return ESTIMATION_FORMAT.format(reference.getTime());
                }else if(this.bit == 1<<2){
                    temp.setTime(reference);
                    temp.add(Calendar.DATE,1);
                    return ESTIMATION_FORMAT.format(temp);
                }else if(this.bit == 1<<3){
                    temp.setTime(reference);
                    temp.add(Calendar.DATE,2);
                    return ESTIMATION_FORMAT.format(temp);
                }else{
                    temp.setTime(reference);
                    temp.add(Calendar.DATE,5);
                    return ESTIMATION_FORMAT.format(temp);
                }
        }
    
    
    @Override
    public boolean read(String content){
        return false;
    }

}
