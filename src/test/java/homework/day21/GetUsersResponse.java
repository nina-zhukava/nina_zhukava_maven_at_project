package homework.day21;

import java.util.List;
import java.util.Objects;

public class GetUsersResponse {

    String code;
    List<User> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUsersResponse that = (GetUsersResponse) o;
        return Objects.equals(code, that.code) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, data);
    }
}
