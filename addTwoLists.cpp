#include <iostream>
#include <cmath>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

long long convertToInteger(ListNode *l);
ListNode *createNode(int val);
ListNode *insert(ListNode *head, int val);

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    int len1 = 0, len2 = 0;

    long long num1 = convertToInteger(l1);
    long long num2 = convertToInteger(l2);
    long long sum = num1 + num2;

    if (sum == 0)
        return createNode(0);

    ListNode *head = NULL;

    while (sum != 0)
    {
        int digit = sum % 10;
        sum /= 10;
        head = insert(head, digit);
    }

    return head;
}

long long convertToInteger(ListNode *l)
{
    if (l == NULL)
        return 0;

    long long num = l->val;
    int i = 1;

    l = l->next;

    while (l != NULL)
    {
        num += l->val * pow(10, i++);
        l = l->next;
    }

    return num;
}

ListNode *createNode(int val)
{
    ListNode *newNode = new ListNode(val);
    return newNode;
}

ListNode *insert(ListNode *head, int val)
{
    if (head == NULL)
        return createNode(val);

    ListNode *newNode = createNode(val);
    ListNode *temp = head;

    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;

    return head;
}

int main()
{
    ListNode *head1 = NULL, *head2 = NULL;

    head1 = insert(head1, 1);
    head1 = insert(head1, 9);
    head1 = insert(head1, 9);
    head1 = insert(head1, 9);
    head1 = insert(head1, 9);

    head2 = insert(head2, 0);
    head2 = insert(head2, 0);
    head2 = insert(head2, 9);
    head2 = insert(head2, 9);
    head2 = insert(head2, 1);

    ListNode *head = addTwoNumbers(head1, head2);

    while (head != NULL)
    {
        cout << head->val << " "; // Should output 1 9 8 9 1 1
        head = head->next;
    }

    return 0;
}