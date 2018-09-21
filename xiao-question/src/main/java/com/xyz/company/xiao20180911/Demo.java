package com.xyz.company.xiao20180911;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Demo {
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Demo)) {
            return false;
        } else {
            Demo other = (Demo)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Demo;
    }

}
