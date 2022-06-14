#include <iostream>
#include <stack>
using namespace std;

bool validParenthesis(string s)
{
    stack<char> parenthesisStack;

    for (char ch : s)
    {
        if (ch == '{' || ch == '[' || ch == '(')
            parenthesisStack.push(ch);
        else if (ch == '}' || ch == ']' || ch == ')')
        {
            if (parenthesisStack.empty())
                return false;
            char top = parenthesisStack.top();
            if ((top == '{' && ch == '}') || (top == '[' && ch == ']') || (top == '(' && ch == ')'))
                parenthesisStack.pop();
            else
                return false;
        }
    }

    return parenthesisStack.empty();
}