//모르겠어요...

const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let R, C, N;
let Boom_Time[MAX][MAX];
let MAP[MAX][MAX];
 
const dx[] = { 0, 0, 1, -1 };
const dy[] = { 1, -1, 0, 0 };
 
function Input()
{
    cin >> R >> C >> N;
    for (let i = 0; i < R; i++)
    {
        for (let j = 0; j < C; j++)
        {
            cin > MAP[i][j];
            if (MAP[i][j] == 'O')
            {
                Boom_Time[i][j] = 3;
            }
        }
    }
}
 
function Install_Boom()
{
    for (let i = 0; i < R; i++)
    {
        for (let j = 0; j < C; j++)
        {
            if (MAP[i][j] == 'O') continue;
            MAP[i][j] = 'O';
            Boom_Time[i][j] = T + 3;
        }
    }
}
 
function Delete_Boom()
{
    for (let i = 0; i < R; i++)
    {
        for (let j = 0; j < C; j++)
        {
            if (Boom_Time[i][j] == T)
            {
                for (let k = 0; k < 4; k++)
                {
                    let nx = i + dx[k];
                    let ny = j + dy[k];
                    
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (MAP[nx][ny] == '.') continue;
 
                    MAP[nx][ny] = '.';
                }
                MAP[i][j] = '.';
                Boom_Time[i][j] = 0;
            }
        }
    }
}
 
function Print()
{
    for (let i = 0; i < R; i++)
    {
        for (let j = 0; j < C; j++)
        {
            cout < MAP[i][j];
        }
        cout < endl;
    }
}
 
function Solution()
{
    let Time = 2;
    while (1)
    {
        if (Time == N + 1) break;
 
        if (Time % 2 == 0)
        {
            Install_Boom(Time);
        }
        else
        {
            Delete_Boom(Time);
        }
        Time++;
    }
      console.log(input);
    }
}