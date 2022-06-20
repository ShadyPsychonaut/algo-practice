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

ListNode *swapPairs(ListNode *head)
{
    if (head == NULL || head->next == NULL)
        return head;

    ListNode *curr = head;
    head = head->next;
    curr->next = head->next;
    head->next = curr;

    int i = 0;
    ListNode *prev = head;
    ListNode *nxt = curr->next;

    while (nxt != NULL)
    {
        prev = prev->next;
        curr = nxt;
        nxt = nxt->next;

        if (i % 2 == 0)
        {
            prev->next = nxt;
            curr->next = nxt->next;
            nxt->next = curr;

            ListNode *temp = curr;
            curr = nxt;
            nxt = temp;
        }
        i++;
    }

    return head;
}