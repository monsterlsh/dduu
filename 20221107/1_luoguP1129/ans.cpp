#include <cstdio>
#include <cstring>
int Map[205][205], p[205], vis[205], N, T;
bool match(int i)
{
    for (int j = 1; j <= N; ++j)
    {
        if (Map[i][j] && !vis[j])
        {
            vis[j] = 1;
            if (p[j] == 0 || match(p[j]))
            {
                p[j] = i;
                return true;
            }
        }
    }
    return false;
}
int Hungarian()
{
    int cnt = 0;
    for (int i = 1; i <= N; ++i)
    {
        memset(vis, 0, sizeof(vis));
        if (match(i))
            cnt++;
    }
    return cnt;
}
int main()
{
    scanf("%d", &T);
    while (T--)
    {
        scanf("%d", &N);
        memset(p, 0, sizeof(p));
        for (int i = 1; i <= N; ++i)
            for (int j = 1; j <= N; ++j)
                scanf("%d", &Map[i][j]);
        puts(Hungarian() == N ? "Yes" : "No");
    }
    return 0;
}