package by.tms.project.config;

import java.util.List;

public enum TypeOperation {
    PLUS {
        public String getName() {
            return "сложение";
        }
        public String getNameParam() {
            return "plus";
        }
        public float action(List<Integer> integers) {
            float res = 0;
            for(int item : integers) {
                res += item;
            }
            return res;
        }
    },
    MINUS {
        public String getName() {
            return "вычитание";
        }
        public String getNameParam() {
            return "minus";
        }
        public float action(List<Integer> integers) {
            float res = integers.get(0);
            for(int i=1; i<integers.size(); i++) {
                res -= integers.get(i);
            }
            return res;
        }
    };
    public abstract String getName();
    public abstract String getNameParam();
    public abstract float action(List<Integer> integers);
}
