#include <iostream>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *removeNthFromEnd(ListNode *head, int n)
{
    if (head->next == NULL && n == 1)
        return NULL;
    int length = 0;
    ListNode *temp = head;
    while (temp != NULL)
    {
        temp = temp->next;
        length++;
    }

    temp = head;

    if (length == n)
    {
        head = head->next;
        delete temp;
        return head;
    }

    for (int i = 1; i < length - n; i++)
        temp = temp->next;

    if (temp->next != NULL)
    {
        ListNode *temp2 = temp->next;
        temp->next = temp2->next;
        delete temp2;
    }

    return head;
}