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

// Recursive solution (May exceed stack space)
ListNode *deleteDuplicates(ListNode *head)
{
    if (head == NULL || head->next == NULL)
        return head;

    head->next = deleteDuplicates(head->next);

    if (head->val == head->next->val)
    {
        ListNode *temp = head->next;
        head->next = temp->next;
        delete temp;
    }

    return head;
}

// Iterative solution
ListNode *deleteDuplicatesIter(ListNode *head)
{
    ListNode *curr = head;
    while (curr != NULL)
    {
        while (curr->next != NULL && curr->val == curr->next->val)
        {
            ListNode *temp = curr->next;
            curr->next = temp->next;
            delete temp;
        }
        curr = curr->next;
    }

    return head;
}