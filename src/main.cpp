#include "include/list.h"


int main(int arg_count, char *args[]) {

    if(arg_count > 1) {

        List myList;
        myList.name = string(args[1]);
        myList.print_menu();

    }
    else {
        cout << "Exiting" << endl;
    }

    return 0;
}
