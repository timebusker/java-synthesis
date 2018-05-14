package com.timebusker.item1;// Simple test program for service provider framework

public class Test {
    public static void main(String[] args) {
        // Providers would execute these lines
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        // Clients would execute these lines
        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        System.out.printf("%s, %s, %s%n", s1, s2, s3);
    }

    private static Provider DEFAULT_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Default service";
                }
            };
        }
    };

    private static Provider COMP_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Complementary service";
                }
            };
        }
    };

    private static Provider ARMED_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Armed service";
                }
            };
        }
    };


    @org.junit.Test
    public void testThis() {
        object1 obj1 = new object1();
        object2 obj2 = new object2();
        object3 obj3 = new object3();
        System.out.println("\t0.....\t" + this.hashCode());
        obj1.dopritln();
        obj2.dopritln();
        obj3.dopritln();
        System.out.println("************************");
        obj1.dopritlns();
        obj2.dopritlns();
        obj3.dopritlns();
    }
}

class object1 {
    public void dopritln() {
        System.out.println("\t1.....\t" + this.hashCode());
    }

    public void dopritlns() {
        object2 obj = new object2();
        obj.dopritln();
    }

    @Override
    public int hashCode() {
        return 11111;
    }
}

class object2 {
    public void dopritln() {
        System.out.println("\t2.....\t" + this.hashCode());
    }

    public void dopritlns() {
        object3 obj = new object3();
        obj.dopritln();
    }

    @Override
    public int hashCode() {
        return 22222;
    }
}

class object3 {
    public void dopritln() {
        System.out.println("\t3.....\t" + this.hashCode());
    }

    public void dopritlns() {
        object1 obj = new object1();
        obj.dopritln();
    }

    @Override
    public int hashCode() {
        return 33333;
    }
}