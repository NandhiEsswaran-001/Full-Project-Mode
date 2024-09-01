#include "include/list.h"

void List::print_menu() {
    int choice;
    cout << "\n";
    cout << "*****************" << endl;
    cout << "1.Print List\n";
    cout << "2.Add to list\n";
    cout << "3.Delete from List\n";
    cout << "4.Quit\n";
    cout << "Enter your choice: ";

    cin >> choice;

    if(choice == 4){
        exit(0);
    }
    else if(choice == 2) {
        add_item();
    }
    else if(choice == 3) {
        delete_item();
    }
    else if(choice == 1) {
        print_list();
    }
    else {
        cout << "Choice not implemented!" << "\n";
    }
}

void List::add_item() {

    cout << "\n";
    cout << "Add item\n";
    cout << "Type an item\n";

    string item;
    cin >> item;

    list.push_back(item);

    cout << "Successfully Added!\n";
    cin.clear();

    print_menu();
}

void List::delete_item() {

    cout << "\n";
    cout << "Delete item\n";
    cout << "Select Index number to delete: \n";

    if(list.size()) {

        for(unsigned int i = 0; i < list.size(); i++) {

            cout << i << ": " << list[i] << endl;

        }
        int choiceNum;
        cin >> choiceNum;
        list.erase(list.begin() + choiceNum);
    }
    else {
        cout << "No Items in the list\n";
    }

    print_menu();
}

void List::print_list() {

    cout << "\n";
    cout << "Printing List\n";

    for(unsigned int i = 0; i < list.size(); i++) {

        cout << " * " << list[i] << "\n";

    }

    cout << "M - Menu\n";
    char choice;
    cin >> choice;

    if(choice == 'M' || choice == 'm') {
        print_menu();
    }
    else {
        cout << "Invalid Choice!\n";
    }

}