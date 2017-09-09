# TouchEvent

## This is a tutorial project to help you understand Android TouchEvent, whats including in the projects:
- An sample Android project that has a a **ViewGroup**, **View**, **Activity** with its relevant method been logged.
- Screen Shot of method logging to show touchevent sequence.

### What is a TouchEvent:
A touchEvent is a series of action that always including (only one ACTION_DOWN), and (0 - any ACTION_MOVE) and (only one ACTION_UP).

Just imagine when you quickly tap the screen, the second you firgure touchs screen, the ACTION_DOWN event is trigger, and depends on whether you move your firgure while still touch the screen, it will trigger 0 - any of ACTION_MOVE. Finally, when you move your fingure away from the screen, once your firgure aparts from screen, the ACTION_UP is triggered. That is a complete TouchEvent series. __Remember, When your firgure left the screen, which the ACTION_UP is triggered. This touchEvent series is finish, if you touch screen after that, a brand new TouchEvent series will be calculated.__

### Three different class that can accept touchEvent and its available method:
- Activity has **dispatchTouchEvent** and **onTouchEvent**

- ViewGroup has **dispatchTouchEvent**, **onInterceptTouchEvent** and **onTouchEvent**

- View has **dispatchTouchEvent** and **onTouchEvent**

In a sense, when a touchEvent is triggered, the rootView alway first received the Event, and if rootView is not intereted in consuming this 
