//include "Commons.thrift"

namespace java com.users

enum Gender {
  Male = 1, Female = 2, Other = 3
}

struct Address {
    1: string locality,
    2: string country
}

struct User {
    1: string id,
    2: string name,
    3: i32 age,
    4: Gender gender,
    5: list<string> roles,
    6: optional map<string, Address> addresses
}

service UserAPIs {
    void saveUser(1: User user);
    string ping();
}