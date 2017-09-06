#include <stdlib.h>
#include <unistd.h>
#include <dirent.h>

int main() {
    execl("/usr/bin/mousepad", "mousepad", NULL);
    return 0;
}
