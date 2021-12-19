package com.EmirMuhamadZaidJmartAK;


/**
 * Transactor Interface
 */

public interface Transactor
{
        public abstract boolean validate();
        public abstract Invoice perform();
}